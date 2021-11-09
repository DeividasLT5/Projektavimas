import main.MainModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainModuleTest {
    MainModule mainModule;

    @BeforeEach
    void setUp() {
        mainModule = new MainModule();
    }
    @Test
    void TestValidatesPassword() {
        assertFalse(mainModule.isPasswordInvalid("jgihaG_"));
        assertTrue(mainModule.isPasswordInvalid("ab"));
        assertTrue(mainModule.isPasswordInvalid("jgihag_"));
    }
    @Test
    void TestValidatesNumber() {
        assertFalse(mainModule.isPhoneInvalid("861238471"));
        assertTrue(mainModule.isPhoneInvalid("A486/46"));
        assertTrue(mainModule.isPhoneInvalid("5861335864856"));


    }
    @Test
    void TestValidatesEmail() {
        assertFalse(mainModule.isEmailInvalid("test@gmail.com"));
        assertTrue(mainModule.isEmailInvalid("test@gmail"));
        assertTrue(mainModule.isEmailInvalid("testgmail.com"));

    }
}
