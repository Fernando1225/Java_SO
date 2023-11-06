public interface IntegralNamingSystem {
    void bind(String name, Object resource);
    void unbind(String name);
    Object lookup(String name);
}