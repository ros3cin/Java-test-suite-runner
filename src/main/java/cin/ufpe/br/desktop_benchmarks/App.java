package cin.ufpe.br.desktop_benchmarks;

import java.io.IOException;

import cin.ufpe.br.desktop_benchmarks.api.IBenchmark;
import cin.ufpe.br.desktop_benchmarks.impl.CommonsMathBenchmark;
import cin.ufpe.br.desktop_benchmarks.impl.GsonBenchmark;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException
    {
    	EnergyCheckUtils.ProfileInit();
        IBenchmark bench = new GsonBenchmark(100,1000, 12000);
        bench.warmup();
        int nOfReps = 600;
        int repeatExp = nOfReps;
        while((repeatExp--) > 0) {
	        double packageBefore = EnergyCheckUtils.getEnergyStats()[2];
	        bench.run();
	        double packageAfter = EnergyCheckUtils.getEnergyStats()[2];
	        System.out.print(packageAfter-packageBefore);
	        if(repeatExp > 0) {
	        	System.out.print(",");
	        }
        }
    	EnergyCheckUtils.ProfileDealloc();
    }
}
