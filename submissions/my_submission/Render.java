import interfaces.IRenderObject;

public class Render {

    private IRenderObject[] objects = new IRenderObject[0];

    public boolean addRenderObject(IRenderObject object) {
        // object already in objects?
        for (IRenderObject obj : this.objects) {
            if (obj != null && obj.equals(object)) return false;
        }
        // if possible replace null value (reverse loop to replace last value first)
        for (int i=this.objects.length-1; i>=0; i--) {
            if (this.objects[i] == null) {
                this.objects[i] = object;
                return true;
            }
        }
        // no null value! extend array and append object
        this.objects = this.extend(this.objects, object);
        return true;
    }

    // method to extend array and append element
    private IRenderObject[] extend(IRenderObject[] array, IRenderObject object) {
        IRenderObject[] ret_array = new IRenderObject[array.length+1];
        for (int i=0; i<array.length; i++) {
            ret_array[i] = array[i];
        }
        ret_array[ret_array.length-1] = object;
        return ret_array;
    }

    public boolean removeRenderObject(IRenderObject object) {
        for (int i=0; i<this.objects.length; i++) {
            if (this.objects[i] != null && this.objects[i].equals(object)) {
                this.objects[i] = null;
                return true;
            }
        }
        return false;
    }

    public void render() {
        for (IRenderObject obj : this.objects) {
            if (obj != null) obj.render();
        }
    }
}
