import TagService from "./js/TagService.js";
import Tabella from "./js/Tabella.js"; 

const prop = {};
prop.titolo = "Elenco TAGS";
prop.service= new TagService();
prop.idTabella = "tblTags";
prop.classeTabella= "pure-table";
prop.contenitore = "#contenitore";
        
new Tabella(prop);