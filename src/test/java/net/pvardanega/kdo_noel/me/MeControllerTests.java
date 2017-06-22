package net.pvardanega.kdo_noel.me;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({
    "classpath:db/delete_all.sql",
    "classpath:db/principal.sql"
})
public class MeControllerTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders
            .webAppContextSetup(this.context)
            .alwaysDo(MockMvcResultHandlers.print())
            .build();
    }

    @Test
    public void should_get_principal() throws Exception {
        mvc.perform(get("/me")
            .accept(APPLICATION_JSON_UTF8_VALUE))
            .andExpect(status().isOk())
            .andExpect(jsonPath("firstName").value("Pierre-Jean"))
            .andExpect(jsonPath("lastName").value("Vardanéga"));
    }

    @Test
    public void should_principals_list() throws Exception {
        mvc.perform(get("/me/list"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("id").value(1L))
            .andExpect(jsonPath("envies").value(hasSize(2)))
            .andExpect(jsonPath("envies[?(@.title == 'Robot aspirateur')].subtitle").value("Marque et modèle : NEATO 945-0062"))
            .andExpect(jsonPath("envies[?(@.title == 'Robot aspirateur')].imageUrl").value("https://s2.qwant.com/thumbr/0x0/6/d/9a65cce977b23e15242f206b1ee1af/b_1_q_0_p_0.jpg?u=http%3A%2F%2F1.bp.blogspot.com%2F-f9TG8p2vBho%2FVHO3QWBwHFI%2FAAAAAAAAA0E%2Fond8gQU2mC8%2Fs1600%2FNeato%252B945-0062%252BSignature%252BAspirateur%252BRobot%252BNoir.jpg"))
            .andExpect(jsonPath("envies[?(@.title == 'Robot aspirateur')].content").value("Deux types de prise électrique : EU et UK\\nL'autonomie de l'appareil est de 1h à 1H30 selon la configuration de la pièce à nettoyer; L'autonomie maximale est obtenue après environ 8 à 10 charges complètes de la batterie\\nNom du modèle : XV signature"))
            .andExpect(jsonPath("envies[?(@.title == 'Stage enduro')].subtitle").value("à Verbier, le week-end du 17 juillet 2017"))
            .andExpect(jsonPath("envies[?(@.title == 'Stage enduro')].imageUrl").value("http://www.verbierbikepark.ch/images/events_7_G.jpg"))
            .andExpect(jsonPath("envies[?(@.title == 'Stage enduro')].content").value("2 jours d'enduro sur les plus beaux \"singles\" du Val de Bagnes.\\n\\nNOUVEAUTÉS 2017:\\n\\n- camp de 2 jours aulieu de 3. Uniquement 1 nuit à la cabane Mt_Fort à 2500m!\\n- si vous êtes 4-6 amis, vous avez la possibilité de constituer un groupe que entre vous (4-6 personnes pour un guide). À noter simplement sur le formulaire d'inscription!"))
        ;
    }
}