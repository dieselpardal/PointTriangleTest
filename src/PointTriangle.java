import java.awt.*;

class PointTriangle {

    int width = 800;
    int height = 600;
    int speed = 0;
    int pointsMax =1000;
    Point pA = null;
    Point pB= null;
    Point pC= null;
    Point stepA= null;
    Point stepB= null;
    Point stepC= null;

    void valueDefault() {
        this.speed = 3;
        this.pA = new Point(100,100);
        this.pB = new Point(400,200);
        this.pC = new Point(400,600);
        this.stepA = new Point(this.speed,this.speed);
        this.stepB = new Point(-this.speed,-this.speed);
        this.stepC = new Point(this.speed,-this.speed);
    }

    void relogio(Graphics g) {
        this.stepA = inverseIfOut(pA,this.stepA);
        this.stepB = inverseIfOut(pB,this.stepB);
        this.stepC = inverseIfOut(pC,this.stepC);
        this.pA= setP(this.pA,this.stepA);
        this.pB= setP(this.pB,this.stepB);
        this.pC= setP(this.pC,this.stepC);

        triangle(g, pA, pB, pC);

        for (int i=0;i<this.pointsMax;i++) {
            int x = (int) (this.width * Math.random());
            int y = (int) (this.height * Math.random());
            g.setColor(Color.white);
            if (PointTrangleIn(new Point(x,y), pA, pB, pC)) {
                g.setColor(Color.red);
            }
            g.drawOval(x, y, 1, 1);
        }
    }

    void cls(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0,  this.width,  this.height);
    }

    private Point setP(Point P, Point S) {
        P.x+=S.x;
        P.y+=S.y;
        return P;
    }

    private Point inverseIfOut(Point p, Point step) {
        if(p.x>this.width || p.x<0 ) step.x=-step.x;
        if(p.y>this.height || p.y<0) step.y=-step.y;
        return step;
    }

    private double sign(Point pa, Point pb, Point pc){
        return (pa.x - pc.x) * (pb.y - pc.y) - (pb.x - pc.x) * (pa.y - pc.y);
    }

    private boolean PointTrangleIn(Point pt, Point pa, Point pb, Point pc) {
        double d1, d2, d3;
        boolean has_neg, has_pos;
        d1 = sign(pt, pa, pb);
        d2 = sign(pt, pb, pc);
        d3 = sign(pt, pc, pa);
        has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
        has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);
        return !(has_neg && has_pos);
    }

    private void triangle(Graphics g, Point a, Point b, Point c) {
        g.setColor(Color.red);
        g.drawLine(a.x, a.y, b.x, b.y);
        g.drawLine(b.x, b.y, c.x, c.y);
        g.drawLine(c.x, c.y, a.x, a.y);
    }
}
