package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateSocieteRequestDto;
import com.mera.shine.dto.response.SocieteDto;
import com.mera.shine.dto.response.SiteDto;
import com.mera.shine.dto.response.GroupDto;
import com.mera.shine.dto.response.LigneConditionPaiementDto;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SuperAdminServiceImplTest {

    @Mock
    private SocieteService societeService;

    @Mock
    private ModePaiementService modePaiementService;

    @Mock
    private UniteMesureService uniteMesureService;

    @Mock
    private TaxeService taxeService;

    @Mock
    private SiteService siteService;

    @Mock
    private TierService tierService;

    @Mock
    private UtilisateurService utilisateurService;

    @Mock
    private GroupService groupService;

    @Mock
    private GroupsRoleService groupsRoleService;

    @Mock
    private LigneConditionPaiementService ligneConditionPaiementService;

    @Mock
    private ItemsConditionPaiementService itemsConditionPaiementService;

    @Mock
    private RoleService roleService;

    private SuperAdminServiceImpl superAdminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        superAdminService = new SuperAdminServiceImpl(
            societeService, 
            modePaiementService, 
            uniteMesureService, 
            taxeService,
            siteService,
            tierService,
            utilisateurService,
            groupService,
            groupsRoleService,
            ligneConditionPaiementService,
            itemsConditionPaiementService,
            roleService
        );
    }

    @Test
    void testCreateSocietyAndInitEntity_Success() {
        // Given
        CreateSocieteRequestDto requestDto = new CreateSocieteRequestDto(
            "Test Company",
            "Test Activity", 
            "Test Address",
            "BP 123",
            "Cameroon",
            "Centre",
            "123456789",
            "NC123",
            "RCCM123",
            "Normal",
            "XAF",
            "logo.png",
            "favicon.ico"
        );

        SocieteDto mockSocieteDto = new SocieteDto(
            1,
            "Test Company",
            "Test Activity",
            "Test Address", 
            "BP 123",
            "Cameroon",
            "Centre",
            "123456789",
            "NC123",
            "RCCM123",
            "Normal",
            "XAF",
            "logo.png",
            "favicon.ico",
            Set.of()
        );

        // Mock the new services
        SiteDto mockSiteDto = new SiteDto(1, "Site Principal", "SITE01", "Site principal de la société", "Ville principale", "Pays principal", (short) 1, 1, Set.of(), Set.of());
        GroupDto mockGroupDto = new GroupDto(1, "Administrateurs", 1, 1, 1, Set.of());

        // Mock LigneConditionPaiement DTOs
        LigneConditionPaiementDto comptantDto = new LigneConditionPaiementDto(1, "Comptant", "Paiement comptant", 1, Set.of());
        LigneConditionPaiementDto credit30Dto = new LigneConditionPaiementDto(2, "30 jours", "Paiement à 30 jours", 1, Set.of());
        LigneConditionPaiementDto credit60Dto = new LigneConditionPaiementDto(3, "60 jours", "Paiement à 60 jours", 1, Set.of());

        when(societeService.create(any(CreateSocieteRequestDto.class))).thenReturn(mockSocieteDto);
        when(siteService.create(any())).thenReturn(mockSiteDto);
        when(groupService.create(any())).thenReturn(mockGroupDto);
        when(ligneConditionPaiementService.create(any())).thenReturn(comptantDto, credit30Dto, credit60Dto);

        // When
        boolean result = superAdminService.createSocietyAndInitEntity(requestDto);

        // Then
        assertTrue(result);

        // Verify that societe was created
        verify(societeService, times(1)).create(requestDto);

        // Verify that default payment methods were created (4 default payment methods)
        verify(modePaiementService, times(4)).create(any());

        // Verify that default units of measure were created (4 default units)
        verify(uniteMesureService, times(4)).create(any());

        // Verify that default taxes were created (4 default taxes)
        verify(taxeService, times(4)).create(any());

        // Verify that default site was created
        verify(siteService, times(1)).create(any());

        // Verify that default ligne condition paiement were created (3 default conditions)
        verify(ligneConditionPaiementService, times(3)).create(any());

        // Verify that default items condition paiement were created (3 default items)
        verify(itemsConditionPaiementService, times(3)).create(any());

        // Verify that default group was created
        verify(groupService, times(1)).create(any());

        // Note: Group roles creation is currently commented out in the implementation
        // verify(groupsRoleService, times(3)).create(any());

        // Verify that default tier was created
        verify(tierService, times(1)).create(any());

        // Verify that default utilisateur was created
        verify(utilisateurService, times(1)).create(any());
    }

    @Test
    void testCreateSocietyAndInitEntity_Failure() {
        // Given
        CreateSocieteRequestDto requestDto = new CreateSocieteRequestDto(
            "Test Company",
            "Test Activity",
            "Test Address",
            "BP 123", 
            "Cameroon",
            "Centre",
            "123456789",
            "NC123",
            "RCCM123",
            "Normal",
            "XAF",
            "logo.png",
            "favicon.ico"
        );

        when(societeService.create(any(CreateSocieteRequestDto.class)))
            .thenThrow(new RuntimeException("Database error"));

        // When
        boolean result = superAdminService.createSocietyAndInitEntity(requestDto);

        // Then
        assertFalse(result);

        // Verify that societe creation was attempted
        verify(societeService, times(1)).create(requestDto);

        // Verify that no default entities were created due to the exception
        verify(modePaiementService, never()).create(any());
        verify(uniteMesureService, never()).create(any());
        verify(taxeService, never()).create(any());
        verify(siteService, never()).create(any());
        verify(ligneConditionPaiementService, never()).create(any());
        verify(itemsConditionPaiementService, never()).create(any());
        verify(groupService, never()).create(any());
        verify(groupsRoleService, never()).create(any());
        verify(tierService, never()).create(any());
        verify(utilisateurService, never()).create(any());
    }
}
