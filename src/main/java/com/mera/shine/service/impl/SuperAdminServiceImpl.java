package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateAdresseRequestDto;
import com.mera.shine.dto.request.CreateSocieteRequestDto;
import com.mera.shine.dto.request.CreateModePaiementRequestDto;
import com.mera.shine.dto.request.CreateUniteMesureRequestDto;
import com.mera.shine.dto.request.CreateTaxeRequestDto;
import com.mera.shine.dto.request.CreateSiteRequestDto;
import com.mera.shine.dto.request.CreateTierRequestDto;
import com.mera.shine.dto.request.CreateUtilisateurRequestDto;
import com.mera.shine.dto.request.CreateGroupRequestDto;
import com.mera.shine.dto.request.CreateGroupsRoleRequestDto;
import com.mera.shine.dto.request.CreateLigneConditionPaiementRequestDto;
import com.mera.shine.dto.request.CreateItemsConditionPaiementRequestDto;
import com.mera.shine.dto.response.AdresseDto;
import com.mera.shine.dto.response.SocieteDto;
import com.mera.shine.dto.response.SiteDto;
import com.mera.shine.dto.response.GroupDto;
import com.mera.shine.dto.response.LigneConditionPaiementDto;
import com.mera.shine.entity.Adresse;
import com.mera.shine.mapper.AdresseMapper;
import com.mera.shine.repository.AdresseRepository;
import com.mera.shine.service.AdresseService;
import com.mera.shine.service.SuperAdminService;
import com.mera.shine.service.SocieteService;
import com.mera.shine.service.ModePaiementService;
import com.mera.shine.service.UniteMesureService;
import com.mera.shine.service.TaxeService;
import com.mera.shine.service.SiteService;
import com.mera.shine.service.TierService;
import com.mera.shine.service.UtilisateurService;
import com.mera.shine.service.GroupService;
import com.mera.shine.service.GroupsRoleService;
import com.mera.shine.service.LigneConditionPaiementService;
import com.mera.shine.service.ItemsConditionPaiementService;
import com.mera.shine.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the AdresseService interface.
 */
@Service
@Transactional
public  class SuperAdminServiceImpl implements SuperAdminService {

    private final SocieteService societeService;
    private final ModePaiementService modePaiementService;
    private final UniteMesureService uniteMesureService;
    private final TaxeService taxeService;
    private final SiteService siteService;
    private final TierService tierService;
    private final UtilisateurService utilisateurService;
    private final GroupService groupService;
    private final GroupsRoleService groupsRoleService;
    private final LigneConditionPaiementService ligneConditionPaiementService;
    private final ItemsConditionPaiementService itemsConditionPaiementService;
    private final RoleService roleService;

    @Autowired
    public SuperAdminServiceImpl(SocieteService societeService, 
                                ModePaiementService modePaiementService,
                                UniteMesureService uniteMesureService,
                                TaxeService taxeService,
                                SiteService siteService,
                                TierService tierService,
                                UtilisateurService utilisateurService,
                                GroupService groupService,
                                GroupsRoleService groupsRoleService,
                                LigneConditionPaiementService ligneConditionPaiementService,
                                ItemsConditionPaiementService itemsConditionPaiementService,
                                RoleService roleService) {
        this.societeService = societeService;
        this.modePaiementService = modePaiementService;
        this.uniteMesureService = uniteMesureService;
        this.taxeService = taxeService;
        this.siteService = siteService;
        this.tierService = tierService;
        this.utilisateurService = utilisateurService;
        this.groupService = groupService;
        this.groupsRoleService = groupsRoleService;
        this.ligneConditionPaiementService = ligneConditionPaiementService;
        this.itemsConditionPaiementService = itemsConditionPaiementService;
        this.roleService = roleService;
    }

    @Override
    public boolean createSocietyAndInitEntity(CreateSocieteRequestDto societeRequestDto) {
        try {
            // 1. Create the society
            SocieteDto createdSociete = societeService.create(societeRequestDto);
            Integer societeId = createdSociete.id();

            // 2. Create default payment methods
            createDefaultPaymentMethods(societeId);

            // 3. Create default units of measure
            createDefaultUnitsOfMeasure(societeId);

            // 4. Create default taxes
            createDefaultTaxes(societeId);

            // 5. Create default site
            SiteDto defaultSite = createDefaultSite(societeId);

            // 6. Create default ligne condition paiement
            List<LigneConditionPaiementDto> ligneConditionPaiements = createDefaultLigneConditionPaiement(societeId);

            // 7. Create default items condition paiement
            createDefaultItemsConditionPaiement(ligneConditionPaiements);

            // 8. Create default group
            GroupDto defaultGroup = createDefaultGroup(societeId);

            // 9. Create default group roles (requires existing roles)
           // createDefaultGroupRoles(defaultGroup.id());

            // 10. Create default tier
            createDefaultTier(societeId);

            // 11. Create default utilisateur
            createDefaultUtilisateur(societeId, defaultSite.id(), defaultGroup.id());

            return true;
        } catch (Exception e) {
            // Log the error and return false
            System.err.println("Error creating society and initializing entities: " + e.getMessage());
            return false;
        }
    }

    private void createDefaultPaymentMethods(Integer societeId) {
        // Create default payment methods
        CreateModePaiementRequestDto especes = new CreateModePaiementRequestDto("Espèces", 0, societeId);
        CreateModePaiementRequestDto cheque = new CreateModePaiementRequestDto("Chèque", 2, societeId);
        CreateModePaiementRequestDto virement = new CreateModePaiementRequestDto("Virement", 2, societeId);
        CreateModePaiementRequestDto carte = new CreateModePaiementRequestDto("Carte bancaire", 2, societeId);

        modePaiementService.create(especes);
        modePaiementService.create(cheque);
        modePaiementService.create(virement);
        modePaiementService.create(carte);
    }

    private void createDefaultUnitsOfMeasure(Integer societeId) {
        // Create default units of measure
        CreateUniteMesureRequestDto piece = new CreateUniteMesureRequestDto("PCS", "Pièce", 1, societeId);
        CreateUniteMesureRequestDto kg = new CreateUniteMesureRequestDto("KG", "Kilogramme", 0, societeId);
        CreateUniteMesureRequestDto litre = new CreateUniteMesureRequestDto("L", "Litre", 0, societeId);
        CreateUniteMesureRequestDto metre = new CreateUniteMesureRequestDto("CAT", "Carton", 0, societeId);

        uniteMesureService.create(piece);
        uniteMesureService.create(kg);
        uniteMesureService.create(litre);
        uniteMesureService.create(metre);
    }

    private void createDefaultTaxes(Integer societeId) {
        // Create default taxes (TVA examples)
        CreateTaxeRequestDto tva0 = new CreateTaxeRequestDto("TVA 0%", 1, 0.0, 1, 0, societeId);
        CreateTaxeRequestDto tva5 = new CreateTaxeRequestDto("TVA 5%", 1, 5.0, 1, 0, societeId);
        CreateTaxeRequestDto tva10 = new CreateTaxeRequestDto("TVA 2%", 1, 2.0, 1, 0, societeId);
        CreateTaxeRequestDto tva20 = new CreateTaxeRequestDto("TVA 19,25%", 1, 19.25, 1, 0, societeId);

        taxeService.create(tva0);
        taxeService.create(tva5);
        taxeService.create(tva10);
        taxeService.create(tva20);
    }

    private SiteDto createDefaultSite(Integer societeId) {
        // Create default site
        CreateSiteRequestDto defaultSite = new CreateSiteRequestDto(
            "Site Principal", 
            "SITE03",
            "Site principal de la société", 
            "Ville principale", 
            "Pays principal", 
            (short) 1,
            societeId
        );
        return siteService.create(defaultSite);
    }

    private List<LigneConditionPaiementDto> createDefaultLigneConditionPaiement(Integer societeId) {
        // Create default payment conditions
        CreateLigneConditionPaiementRequestDto comptant = new CreateLigneConditionPaiementRequestDto(
            "Comptant", 
            "Paiement comptant", 
            societeId
        );
        CreateLigneConditionPaiementRequestDto credit30 = new CreateLigneConditionPaiementRequestDto(
            "30 jours", 
            "Paiement à 30 jours", 
            societeId
        );
        CreateLigneConditionPaiementRequestDto credit60 = new CreateLigneConditionPaiementRequestDto(
            "60 jours", 
            "Paiement à 60 jours", 
            societeId
        );

        LigneConditionPaiementDto comptantDto = ligneConditionPaiementService.create(comptant);
        LigneConditionPaiementDto credit30Dto = ligneConditionPaiementService.create(credit30);
        LigneConditionPaiementDto credit60Dto = ligneConditionPaiementService.create(credit60);

        return List.of(comptantDto, credit30Dto, credit60Dto);
    }

    private void createDefaultItemsConditionPaiement(List<LigneConditionPaiementDto> ligneConditionPaiements) {
        // Create default items condition paiement for each ligne condition paiement
        for (LigneConditionPaiementDto ligneCondition : ligneConditionPaiements) {
            // Create different payment terms for each condition
            if ("Comptant".equals(ligneCondition.lcpNom())) {
                // For cash payment - immediate payment (0 days)
                CreateItemsConditionPaiementRequestDto item = new CreateItemsConditionPaiementRequestDto(
                    1, // icpTypeEcheance - type of due date (1 = immediate)
                    100, // cpiValeur - percentage value (100%)
                    0, // icpDelais - delay in days (0 for cash)
                    ligneCondition.id() // conditionPaiementId
                );
                itemsConditionPaiementService.create(item);
            } else if ("30 jours".equals(ligneCondition.lcpNom())) {
                // For 30 days payment
                CreateItemsConditionPaiementRequestDto item = new CreateItemsConditionPaiementRequestDto(
                    2, // icpTypeEcheance - type of due date (2 = net days)
                    100, // cpiValeur - percentage value (100%)
                    30, // icpDelais - delay in days
                    ligneCondition.id() // conditionPaiementId
                );
                itemsConditionPaiementService.create(item);
            } else if ("60 jours".equals(ligneCondition.lcpNom())) {
                // For 60 days payment
                CreateItemsConditionPaiementRequestDto item = new CreateItemsConditionPaiementRequestDto(
                    2, // icpTypeEcheance - type of due date (2 = net days)
                    100, // cpiValeur - percentage value (100%)
                    60, // icpDelais - delay in days
                    ligneCondition.id() // conditionPaiementId
                );
                itemsConditionPaiementService.create(item);
            }
        }
    }

    private GroupDto createDefaultGroup(Integer societeId) {
        // Create default group
        CreateGroupRequestDto defaultGroup = new CreateGroupRequestDto(
            "Admin",
            1, 
            1, 
            societeId
        );
        return groupService.create(defaultGroup);
    }

    private void createDefaultGroupRoles(Integer groupId) {
        // Create default group roles - assuming some basic roles exist
        // Note: This assumes roles with IDs 1, 2, 3 exist in the system
        try {
            CreateGroupsRoleRequestDto adminRole1 = new CreateGroupsRoleRequestDto(groupId, 1);
            CreateGroupsRoleRequestDto adminRole2 = new CreateGroupsRoleRequestDto(groupId, 2);
            CreateGroupsRoleRequestDto adminRole3 = new CreateGroupsRoleRequestDto(groupId, 3);

            groupsRoleService.create(adminRole1);
            groupsRoleService.create(adminRole2);
            groupsRoleService.create(adminRole3);
        } catch (Exception e) {
            // If roles don't exist, just log and continue
            System.err.println("Warning: Could not create default group roles: " + e.getMessage());
        }
    }

    private void createDefaultTier(Integer societeId) {
        // Create default tier (customer/supplier)
        CreateTierRequestDto defaultTier = new CreateTierRequestDto(
            "TIER003",
            "Client Général", 
            null, 
            null, 
            null, 
            null, 
            0,
            "Client par défaut", 
            (short) 1, 
            0,
            null, 
            null, 
            null, 
            null,
            societeId
        );
        tierService.create(defaultTier);
    }

    private void createDefaultUtilisateur(Integer societeId, Integer siteId, Integer groupId) {
        // Create default user
        CreateUtilisateurRequestDto defaultUser = new CreateUtilisateurRequestDto(
            "Administrateur", 
            null, 
            null, 
            "admin03",
            "admin1235",
            "admin@company7.com",
            "admin1235",
            siteId,
                groupId ,
            societeId
        );
        utilisateurService.create(defaultUser);
    }
}
