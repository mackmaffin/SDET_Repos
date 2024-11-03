public class GenericClass<T> implements IGeneric<T> {
    private T value;
    public GenericClass(T value){
        this.value = value;
    }

    public T getValue (){
        return value;
    }
}
