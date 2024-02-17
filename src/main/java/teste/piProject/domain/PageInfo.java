package teste.piProject.domain;

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
}
