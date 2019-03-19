package GrandTasks.Week3;

public class Task17 {
    public double solutionOfEquation1(double x1, double x2) {    // a) длина гипотенузы
        return Math.hypot(x1, x2);
    }

    public double solutionOfEquation2(double x1, double x2, double x3) {    // б)
        return (x1 * x2 + x1 * x3 + x2 * x3);
    }

    public double solutionOfEquation3(double v, double t, double a) {    // в)
        return (v * t + a * Math.pow(t, 2) / 2);
    }

    public double solutionOfEquation4(double m, double v, double g, double h) {    // г)
        return (m * Math.pow(v, 2) / 2 + m * g * h);
    }

    public double solutionOfEquation5(double r1, double r2) {    // д)
        return (1 / r1 + 1 / r2);
    }

    public double solutionOfEquation6(double m, double g, double angle) {    // е)
        return (m * g * Math.cos(angle));
    }

    public double solutionOfEquation7(double r) {    // ж)
        return (2 * Math.PI * r);
    }

    public double solutionOfEquation9(double b, double a, double c) {    // з)
        return (Math.pow(b, 2) - 4 * a * c);
    }

    private final double GAMMA = 0.5772156649015328606065120900824024310421593359399235988057672348848677267776646709369470632917467495146314472498070824809605040144865428362241739976449235362535003337429373377376739427925952582470949160087352039481656708532331517766115286211995015079847937450857057400299213547861466940296043254215190587755352673313992540129674205137541395491116851028079842348775872050384310939973613725530608893312676001724795378367592713515772261027349291394079843010341777177808815495706610750101619166334015227893586796549725203621287922655595366962817638879272680132431010476505963703947394957638906572967929601009015125195950922243501409349871228247949747195646976318506676129063811051824197444867836380861749455169892792301877391072945781554316005002182844096053772434203285478367015177394398700302370339518328690001558193988042707411542227819716523011073565833967348717650491941812300040654693142999297779569303100503086303418569803231083691640025892970890985486825777364288253954925873629596133298574739302;

    public double solutionOfEquation10(double m1, double m2, double r) {    // и)
        return (GAMMA * m1 * m2 / Math.pow(r, 2));
    }

    public double solutionOfEquation11(double i, double r) {    // к)
        return (Math.pow(i, 2) * r);
    }

    public double solutionOfEquation12(double a, double b, double c) {    // л)
        return (a * b * Math.sin(c));
    }

    public double solutionOfEquation13(double a, double b, double c) {    // м)
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) - 2 * a * b * Math.sin(c));
    }

    public double solutionOfEquation14(double a, double b, double c, double d) {    // н)
        return (a * d + b * c) / a * d;
    }

    public double solutionOfEquation15(double x) {    // о)
        return (Math.sqrt(1 - Math.pow(Math.sin(x), 2)));
    }

    public double solutionOfEquation16(double a, double b, double c, double x) {    // п)
        return 1 / (Math.sqrt(a * Math.pow(a, 2) + b * x + c));
    }

    public double solutionOfEquation17(double x) {    // р)
        return (Math.sqrt(x + 1) + Math.sqrt(x - 1)) / 2 * Math.sqrt(x);
    }

    public double solutionOfEquation18(double x) {    // с)
        return Math.abs(x) + Math.abs(x + 1);
    }

    public double solutionOfEquation4(double x) {    // т)
        return Math.abs(1 - Math.abs(x));
    }
}
