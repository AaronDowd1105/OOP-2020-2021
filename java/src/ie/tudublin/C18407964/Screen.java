package ie.tudublin.C18407964;

public class Screen {
    public int width;
    public int height;
    public int[] pixels;

    public Screen(int width, int height){
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void render(){
        for(int y =0; y < height; y++){
            
            for(int x =0; x < width; x++){
                
               if(x > 10 && y == 20){
                pixels[x + y * width] = 0x0000ff; 
               }
               else{
                pixels[x + y * width] = 0xffffff;
               }
            }


        }

    }
}
