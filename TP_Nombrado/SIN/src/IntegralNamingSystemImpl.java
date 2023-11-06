import java.util.HashMap;
import java.util.Map;

public class IntegralNamingSystemImpl implements IntegralNamingSystem {
    private Map<String, Object> resources;

    public IntegralNamingSystemImpl() {
        this.resources = new HashMap<>();
    }

    @Override
    public void bind(String name, Object resource) {
        resources.put(name, resource);
    }

    @Override
    public void unbind(String name) {
        resources.remove(name);
    }

    @Override
    public Object lookup(String name) {
        return resources.get(name);
    }
}