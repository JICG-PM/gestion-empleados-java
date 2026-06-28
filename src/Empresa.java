import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una empresa y gestiona una lista de empleados
 */
public class Empresa {
    // Atributos
    private String nombre;
    private String nit;
    private List<Empleado> empleados;
    private int contadorId;

    /**
     * Constructor de la empresa
     */
    public Empresa(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.empleados = new ArrayList<>();
        this.contadorId = 1;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }

    /**
     * Agrega un nuevo empleado a la empresa
     */
    public void agregarEmpleado(String nombre, String apellido, String puesto,
                                double salario, String email) {
        Empleado nuevoEmpleado = new Empleado(contadorId++, nombre, apellido,
                puesto, salario, email);
        empleados.add(nuevoEmpleado);
        System.out.println("✅ Empleado agregado exitosamente: " +
                nuevoEmpleado.getNombreCompleto());
    }

    /**
     * Busca un empleado por su ID
     */
    public Empleado buscarEmpleadoPorId(int id) {
        for (Empleado emp : empleados) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    /**
     * Busca empleados por su puesto
     */
    public List<Empleado> buscarEmpleadosPorPuesto(String puesto) {
        List<Empleado> resultado = new ArrayList<>();
        for (Empleado emp : empleados) {
            if (emp.getPuesto().equalsIgnoreCase(puesto)) {
                resultado.add(emp);
            }
        }
        return resultado;
    }

    /**
     * Elimina un empleado por su ID
     */
    public boolean eliminarEmpleado(int id) {
        Empleado emp = buscarEmpleadoPorId(id);
        if (emp != null) {
            empleados.remove(emp);
            System.out.println("🗑️ Empleado eliminado: " + emp.getNombreCompleto());
            return true;
        }
        System.out.println("❌ No se encontró empleado con ID: " + id);
        return false;
    }

    /**
     * Muestra todos los empleados de la empresa
     */
    public void mostrarTodosLosEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("📭 No hay empleados registrados");
            return;
        }

        System.out.println("\n📋 LISTA DE EMPLEADOS DE " + nombre.toUpperCase());
        System.out.println("=".repeat(60));
        for (Empleado emp : empleados) {
            System.out.println(emp.toString());
        }
        System.out.println("Total: " + empleados.size() + " empleados\n");
    }

    /**
     * Calcula el total de salarios de todos los empleados
     */
    public double calcularTotalSalarios() {
        double total = 0;
        for (Empleado emp : empleados) {
            total += emp.getSalario();
        }
        return total;
    }
}
