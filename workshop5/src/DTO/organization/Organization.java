package DTO.organization;
public abstract class Organization{
    private int size;

    public Organization() {
    }

    public Organization(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public abstract void comunitcateByTool();

    @Override
    public String toString() {
        return "Size: "+this.size;
    }
    
}