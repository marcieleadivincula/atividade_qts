/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Server.Entity.Usuario;
import Server.Services.UsuarioService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marci
 */
public class UsuarioServiceTest {
    
    public UsuarioServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
  @Test
    public void usuarioESenhaValidos(){
        Usuario user = new Usuario("admin", "admin");
        UsuarioService userService = new UsuarioService();
        boolean expResult = true;
        boolean result = userService.login(user);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void usuarioESenhaInvalidos() {
        Usuario user = new Usuario("maria", "123");
        UsuarioService userService = new UsuarioService();
        boolean expResult = false;
        boolean result = userService.login(user);

        assertEquals(expResult, result);
    }

    @Test
    public void usuarioInvalidoESenhaValido() {
        Usuario user = new Usuario("maria", "admin");
        UsuarioService userService = new UsuarioService();
        boolean expResult = false;
        boolean result = userService.login(user);

        assertEquals(expResult, result);
    }

    @Test
    public void usuarioValidoESenhaInvalido() {
        Usuario user = new Usuario("admin", "123");
        UsuarioService userService = new UsuarioService();
        boolean expResult = false;
        boolean result = userService.login(user);

        assertEquals(expResult, result);
    }

    @Test
    public void usuarioESenhaVazios() {
        Usuario user = new Usuario("", "");
        UsuarioService userService = new UsuarioService();
        boolean expResult = false;
        boolean result = userService.login(user);

        assertEquals(expResult, result);
    }

    @Test
    public void apenasUsuarioVazio() {
        Usuario user = new Usuario("", "admin");
        UsuarioService userService = new UsuarioService();
        boolean expResult = false;
        boolean result = userService.login(user);

        assertEquals(expResult, result);
    }

    @Test
    public void apenasSenhaVazia() {
        Usuario user = new Usuario("admin", "");
        UsuarioService userService = new UsuarioService();
        boolean expResult = false;
        boolean result = userService.login(user);

        assertEquals(expResult, result);
    }

    @Test
    public void senhaMenosDeOitoCaracteres(){
        Usuario user = new Usuario("juca", "123");
        UsuarioService userService = new UsuarioService();
        boolean expResult = false;
        boolean result = userService.login(user);

        assertEquals(expResult, result);
    }

    @Test
    public void senhaMaisDezCaracteres(){
        Usuario user = new Usuario("joana", "12345678901");
        UsuarioService userService = new UsuarioService();
        boolean expResult = false;
        boolean result = userService.login(user);

        assertEquals(expResult, result);
    }

    @Test
    public void usuarioESenhaVaziosELimpar(){
        Usuario user = new Usuario("admin", "");
        UsuarioService userService = new UsuarioService();
        boolean expResult = false;
        boolean result = userService.login(user);

        assertEquals(expResult, result);
    }
}