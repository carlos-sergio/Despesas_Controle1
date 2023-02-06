import com.sun.management.OperatingSystemMXBean;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.Properties;

//@CarlosSergio****
public class SystemInfo {
    public static void main(String[] args) {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        // Estas 3 linhas usam o método getenv da classe System para obter o nome, a arquitetura do processador e
        // arquitetura de 64 bits do processador
        // Obtendo informações sobre o processador

        String processor = System.getenv("PROCESSOR_IDENTIFIER");
        String architecture = System.getenv("PROCESSOR_ARCHITECTURE");
        String architecture64 = System.getenv("PROCESSOR_ARCHITEW6432");

        long totalMemorySize = osBean.getTotalMemorySize();

        // Esta linha usa o método getFreePhysicalMemorySize da
        // classe OperatingSystemMXBean para obter o tamanho de memória RAM livre no computador.
        // O valor retornado é em ‘bytes’, então precisamos convertê-lo para gigabytes.
        // -- da mesma forma acontece com a linha acima
        long freePhysicalMemorySize = osBean.getFreeMemorySize();

        Properties props = System.getProperties();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Sistema operacional: " + props.getProperty("os.name"));
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Versão do sistema operacional: " + props.getProperty("os.version"));
        System.out.println("-------------------------------------------------------------------------");
        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println("Unidade: " + root.getAbsolutePath());
            System.out.println("Espaço total: " + root.getTotalSpace() / 1024 / 1024 / 1024 + " GB");
            System.out.println("Espaço livre: " + root.getFreeSpace() / 1024 / 1024 / 1024 + " GB");
            System.out.println("-------------------------------------------------------------------------");
        }

        // Aqui O tamanho total de memória RAM é dividido por 1024 três vezes para convertê-lo de ‘bytes’ para gigabytes.
        // O mesmo é feito com o tamanho de memória RAM livre.
        System.out.println("Memória RAM total: " + totalMemorySize / 1024 / 1024 / 1024 + " GB");
        System.out.println("Memória RAM livre: " + freePhysicalMemorySize / 1024 / 1024 / 1024 + " GB");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Processador: " + processor);
        System.out.println("Arquitetura: " + (architecture + architecture64));
        System.out.println("-------------------------------------------------------------------------");
    }
}
