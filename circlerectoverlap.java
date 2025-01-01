class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

        int near_x, near_y;
        near_x = Math.max(x1,Math.min(xCenter,x2));
        near_y = Math.max(y1,Math.min(yCenter,y2));

        int dx, dy;
        dx = Math.abs(near_x - xCenter);
        dy = Math.abs(near_y - yCenter);


        if(((dx*dx)+(dy*dy)) > radius*radius)
        {
            return false;
        }
        else
        {
            return true;
        }
        
    }
}