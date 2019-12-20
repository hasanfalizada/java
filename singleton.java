class SingletonClass {
    private SingletonClass() {
        // private constructor
    }

    public static class SingletonClassHolder {
        public static SingletonClass singletonClass = new SingletonClass();
    }

    public static SingletonClass getInstance() {
        return SingletonClassHolder.singletonClass;
    }

    public void method(String s) {
        // method implementation
        System.err.println(s);
    }
}