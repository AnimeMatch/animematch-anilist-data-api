package teste.piProject.service.Character;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import teste.piProject.service.Character.dto.CardCharacterQuery;
import teste.piProject.service.Character.dto.CharacterImage;
import teste.piProject.service.Character.dto.DataCharacterImage;
import teste.piProject.service.Character.dto.PageCharacter;
import teste.piProject.service.anime.dto.AnimePage;
import teste.piProject.service.anime.dto.CardAnimeQuery;
import teste.piProject.service.queries.Queries;
import teste.piProject.util.DefaultMetods;

import java.util.List;

import static teste.piProject.util.Types.TypeMedia.ANIME;

@Service
public class CharacterService {
    private Queries queries;

    public CharacterService() {
        this.queries = new Queries(ANIME);
    }
    public ResponseEntity<List<CharacterImage>> getFavoriteCharacters(int page, int qtdPaginas){
        try {
            CardCharacterQuery response =
                    DefaultMetods.postRequestByClass(
                            this.queries.buscaCharacters(page, qtdPaginas),
                            CardCharacterQuery.class);
            return ResponseEntity.status(200).body(response.getData().getPage().getCharacters());
        } catch (Exception e){
            throw e;
        }
    }
}
