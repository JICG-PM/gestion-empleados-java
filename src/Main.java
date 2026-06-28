import java.util.List;

/**
 * Clase principal para probar la aplicación de gestión de empleados
 * Demuestra la creación de objetos, uso de métodos y constructores
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("🏢 SISTEMA DE GESTIÓN DE EMPLEADOS");
        System.out.println("=".repeat(40));

        // 1. Crear una empresa (instanciación de objeto)
        Empresa miEmpresa = new Empresa("TechSolutions S.A.", "900123456-7");
        System.out.println("Empresa creada: " + miEmpresa.getNombre());
        System.out.println("NIT: " + miEmpresa.getNit());
        System.out.println();

        // 2. Agregar empleados (usando métodos)
        miEmpresa.agregarEmpleado("Ana", "García", "Desarrolladora Senior", 4500, "ana.garcia@tech.com");
        miEmpresa.agregarEmpleado("Carlos", "López", "Analista de Datos", 3800, "carlos.lopez@tech.com");
        miEmpresa.agregarEmpleado("María", "Rodríguez", "Gerente de Proyectos", 5500, "maria.rodriguez@tech.com");
        miEmpresa.agregarEmpleado("Juan", "Pérez", "Desarrollador Junior", 2800, "juan.perez@tech.com");

        // 3. Mostrar todos los empleados
        miEmpresa.mostrarTodosLosEmpleados();

        // 4. Buscar un empleado por ID
        System.out.println("🔍 Buscando empleado con ID 2:");
        Empleado empleadoBuscado = miEmpresa.buscarEmpleadoPorId(2);
        if (empleadoBuscado != null) {
            System.out.println("   Encontrado: " + empleadoBuscado.getNombreCompleto());
            System.out.println("   Puesto: " + empleadoBuscado.getPuesto());
            System.out.println("   Salario anual: $" + empleadoBuscado.calcularSalarioAnual());
        }
        System.out.println();

        // 5. Buscar empleados por puesto
        System.out.println("🔍 Buscando empleados con puesto 'Desarrollador':");
        List<Empleado> desarrolladores = miEmpresa.buscarEmpleadosPorPuesto("Desarrollador");
        for (Empleado emp : desarrolladores) {
            System.out.println("   - " + emp.getNombreCompleto() + " (" + emp.getPuesto() + ")");
        }
        System.out.println();

        // 6. Modificar un empleado
        System.out.println("✏️ Actualizando información del empleado ID 1:");
        Empleado empActualizar = miEmpresa.buscarEmpleadoPorId(1);
        if (empActualizar != null) {
            empActualizar.setPuesto("Tech Lead");
            empActualizar.setSalario(5200);
            empActualizar.setEmail("ana.techlead@tech.com");
            System.out.println("   Empleado actualizado: " + empActualizar);
        }
        System.out.println();

        // 7. Aplicar aumento de salario
        System.out.println("💰 Aplicando aumento del 10% a todos los empleados:");
        for (Empleado emp : miEmpresa.buscarEmpleadosPorPuesto("Desarrollador")) {
            emp.aplicarAumento(10);
        }
        System.out.println();

        // 8. Total de salarios
        System.out.println("💲 Total de salarios mensuales: $" + miEmpresa.calcularTotalSalarios());
        System.out.println();

        // 9. Eliminar un empleado
        miEmpresa.eliminarEmpleado(4);

        // 10. Mostrar lista final
        miEmpresa.mostrarTodosLosEmpleados();

        System.out.println("✅ Programa finalizado correctamente");
    }
}
