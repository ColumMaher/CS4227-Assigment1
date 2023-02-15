import java.util.List;

public class Dispatcher {

    private List<Logger> interceptors;

    public Dispatcher() {
    }

    public void addInterceptor(Logger l) {
        if (! interceptors.contains(l)) interceptors.add(l);
    }

    public List<Logger> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(List<Logger> interceptors) {
        this.interceptors = interceptors;
    }
}
