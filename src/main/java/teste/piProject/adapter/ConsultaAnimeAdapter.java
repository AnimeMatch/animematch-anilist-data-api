package teste.piProject.adapter;

public class ConsultaAnimeAdapter {
    public static String dadosAnime(){
        String query = """
                {
                  Page (page: 1, perPage: 200) {
                        pageInfo {
                            total
                            currentPage
                            lastPage
                            hasNextPage
                            perPage
                        }
                                
                    }
                      Character{
                      image {
                        large
                        medium
                       \s
                      }
                    media (type: ANIME, sort:SCORE_DESC, format_in: TV, status: FINISHED){
                      id
                      averageScore
                      title{
                        english
                        native
                      }
                      startDate {
                        year
                        month
                        day
                      }
                    }
                  }
                }
                """;
                return query;
    }
}
