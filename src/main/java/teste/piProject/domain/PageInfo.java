package teste.piProject.domain;

import teste.piProject.service.anime.dto.TituloDto;

public class PageInfo {
    private int total;
    private int currentPage;
    private int lastPage;
    private boolean hasNextPage;
    private int perPage;

    public PageInfo() {
    }

    public int getTotal() {
        return total;
    }

    public PageInfo(int total, int currentPage, int lastPage, boolean hasNextPage, int perPage) {
        this.total = total;
        this.currentPage = currentPage;
        this.lastPage = lastPage;
        this.hasNextPage = hasNextPage;
        this.perPage = perPage;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }


    public class AnimeCard {

        private int id;
        private String format;
        private String status;
        private StartEndDate startDate;
        private TituloDto title;
        private CoverImage coverImage;

        public AnimeCard() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public StartEndDate getStartDate() {
            return startDate;
        }

        public void setStartDate(StartEndDate startDate) {
            this.startDate = startDate;
        }

        public TituloDto getTitle() {
            return title;
        }

        public void setTitle(TituloDto title) {
            this.title = title;
        }

        public CoverImage getCoverImage() {
            return coverImage;
        }

        public void setCoverImage(CoverImage coverImage) {
            this.coverImage = coverImage;
        }
    }
}
