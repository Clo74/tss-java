import SedeService from "./js/SedeService.js";
import Tabella from "./js/Tabella.js"; 

new Tabella("Elenco SEDI", new SedeService() , "tblSedi", "pure-table", "#contenitore" );