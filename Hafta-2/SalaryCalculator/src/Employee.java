public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    //tax()	metodu	maaşa	uygulanan	vergi	miktarını	hesaplar.
    public double tax() {
        if (this.salary < 1000) {
            return 0;
        }
        return this.salary * 0.03;
    }

    //bonus() metodu çalışanın	çalıştığı	saat	40	ve	üzeri	ise	üzerine	çalıştığı	saat	başına	30	lira	bonus
    public double bonus() {
        if (this.workHours > 40) {
            return (this.workHours - 40) * 30;
        }
        return 0;
    }


    //raiseSalary() metodu çalışanın	çalışma	yılına	bağlı	olarak	maaş	zammı	hesaplar.
    public double raiseSalary() {
        int year = 2021 - this.hireYear;
        if (year < 10) {
            return this.salary * 0.05;
        } else if (year > 9 && year < 20) {
            return this.salary * 0.10;
        } else {
            return this.salary * 0.15;
        }
    }

    //totalSalary()	metodu	çalışanın	aldığı	maaşı,	vergi	ve	bonuslar	ile	birlikte	hesaplar.
    public double totalSalary() {
        return this.salary + this.raiseSalary() - this.tax() + this.bonus();
    }

    //toString() metodu çalışanın	bilgilerini	ekrana	basar.
    public String toString() {
        return "Adı : " + this.name
                + "\nMaaşı : " + this.salary
                + "\nÇalışma Saati : " + this.workHours
                + "\nBaşlangıç Yılı : " + this.hireYear
                + "\nVergi : " + this.tax()
                + "\nBonus : " + this.bonus()
                + "\nMaaş Artışı : " + this.raiseSalary()
                + "\nVergi ve Bonuslar ile birlikte maaş : "
                + (this.salary - this.tax() + this.bonus())
                + "\nToplam Maaş : " + totalSalary();
    }


}
