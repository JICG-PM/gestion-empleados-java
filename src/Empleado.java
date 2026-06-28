/**
 * Clase que representa a un empleado de la empresa
 * Contiene atributos básicos y métodos para gestionar su información
 */
public class Empleado {
    // Atributos privados (encapsulamiento)
    private int id;
    private String nombre;
    private String apellido;
    private String puesto;
    private double salario;
    private String email;

    /**
     * Constructor completo - Inicializa todos los atributos del empleado
     */
    public Empleado(int id, String nombre, String apellido, String puesto,
                    double salario, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.salario = salario;
        this.email = email;
    }

    /**
     * Constructor simplificado - Crea un empleado con datos mínimos
     */
    public Empleado(int id, String nombre, String apellido) {
        this(id, nombre, apellido, "Sin asignar", 0.0, "sin@email.com");
    }

    // Métodos getter (accesores) y setter (mutadores)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    /**
     * Método para obtener el nombre completo del empleado
     */
    public String getNombreCompleto() {
        return this.nombre + " " + this.apellido;
    }

    /**
     * Calcula el salario anual del empleado (con bono de 2 meses extra)
     */
    public double calcularSalarioAnual() {
        return this.salario * 14; // 12 meses + 2 meses de bono
    }

    /**
     * Aplica un aumento de salario basado en un porcentaje
     */
    public void aplicarAumento(double porcentaje) {
        if (porcentaje > 0) {
            double incremento = this.salario * (porcentaje / 100);
            this.salario += incremento;
            System.out.println("Aumento aplicado. Nuevo salario: $" + this.salario);
        } else {
            System.out.println("El porcentaje debe ser mayor a 0");
        }
    }

    /**
     * Método para mostrar toda la información del empleado
     */
    @Override
    public String toString() {
        return "ID: " + id +
                " | Nombre: " + getNombreCompleto() +
                " | Puesto: " + puesto +
                " | Salario: $" + salario +
                " | Email: " + email;
    }
}
