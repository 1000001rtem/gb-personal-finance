package ru.gd.dev.spring.pfs.ui.system;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gd.dev.spring.pfs.ui.dto.AccountDto;
import ru.gd.dev.spring.pfs.ui.dto.CategoryDto;
import ru.gd.dev.spring.pfs.ui.dto.ClientDto;
import ru.gd.dev.spring.pfs.ui.dto.LogoDto;
import ru.gd.dev.spring.pfs.ui.dto.OperationDto;
import ru.gd.dev.spring.pfs.ui.client.AccountService;
import ru.gd.dev.spring.pfs.ui.client.CategoryService;
import ru.gd.dev.spring.pfs.ui.client.ClientService;
import ru.gd.dev.spring.pfs.ui.client.LogoService;
import ru.gd.dev.spring.pfs.ui.client.OperationService;

import java.math.BigDecimal;
import java.util.List;

//@Component
public class Bootstrap implements InitializingBean {

    @Autowired(required = false)
    private AccountService accountService;

    @Autowired(required = false)
    private CategoryService categoryService;

    @Autowired(required = false)
    private ClientService clientService;

    @Autowired(required = false)
    private LogoService logoService;

    @Autowired(required = false)
    private OperationService operationService;

    @Override
    public void afterPropertiesSet() throws Exception {
        initAccounting();
        initStatistics();
    }

    private void initAccounting() {
        final AccountDto accountDto;
        final boolean isNew = accountService.findAll().isEmpty();
        if (isNew) {
            accountDto = new AccountDto();
            accountDto.setName("TestAccount");
            accountDto.setAmount(BigDecimal.TEN.toString());
        } else {
            accountDto = accountService.findAll().get(0);
        }

        final List<ClientDto> clients = clientService.getAll();
        if (!clients.isEmpty()) accountDto.setClientId(clients.get(0).getId());

        final List<LogoDto> logos = logoService.getAll();
        if (!logos.isEmpty()) accountDto.setLogoId(logos.get(0).getId());

        if (isNew) accountService.create(accountDto);
        else accountService.update(accountDto, accountDto.getId());
    }

    private void initStatistics() {
        final CategoryDto category;
        final ClientDto client;
        final LogoDto logo;
        final OperationDto operation;

        final boolean isCategoryNew = categoryService.getAll().isEmpty();
        final boolean isClientNew = clientService.getAll().isEmpty();
        final boolean isLogoNew = logoService.getAll().isEmpty();
        final boolean isOperationNew = operationService.getAll().isEmpty();

        if (isCategoryNew) {
            category = new CategoryDto();
            category.setName("TestCategory");
            category.setActive(Boolean.TRUE);
        } else {
            category = categoryService.getAll().get(0);
        }

        if (isClientNew) {
            client = new ClientDto();
            client.setName("TestClient");
            client.setActive(Boolean.TRUE);
            client.setCode("TestClientCode");
            client.setComment("TestCLientComment");
        } else {
            client = clientService.getAll().get(0);
        }

        if (isLogoNew) {
            logo = new LogoDto();
            logo.setName("TestLogo");
            logo.setExtension("PNG");
            logo.setPath("testPath");
        } else {
            logo = logoService.getAll().get(0);
        }

        if (isOperationNew) {
            operation = new OperationDto();
            operation.setAmount(BigDecimal.TEN.toString());
            operation.setComment("TestOperationComment");
        } else {
            operation = operationService.getAll().get(0);
        }

        category.setLogoId(logo.getId());

        client.setLogoId(logo.getId());

        operation.setCategoryId(category.getId());
        operation.setLogoId(logo.getId());

        if (isCategoryNew) categoryService.post(category);
        else categoryService.put(category);

        if (isClientNew) clientService.post(client);
        else clientService.put(client);

        if (isLogoNew) logoService.post(logo);
        else logoService.put(logo);

        if (isOperationNew) operationService.post(operation);
        else operationService.put(operation);
    }

}
