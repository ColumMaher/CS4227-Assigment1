import java.util.List;

public class Dispatcher {

    private List<Logger> interceptors;

    public Dispatcher() {
    }

    public void attach(Logger l) {
        if (! interceptors.contains(l)) interceptors.add(l);
    }

    public void detach(Logger l){
        interceptors.remove(l);
    }

    public List<Logger> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(List<Logger> interceptors) {
        this.interceptors = interceptors;
    }
}
