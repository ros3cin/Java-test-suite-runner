package cin.ufpe.br.desktop_benchmarks.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import cin.ufpe.br.desktop_benchmarks.api.IBenchmark;

public class GsonBenchmark implements IBenchmark {
	//for the benchmark
    private GsonClassOne classOne;
    private String classOneJson;
    private Gson gson;
    private int warmUpIterations;
    private int iterations;
    
	public GsonBenchmark(int warmUpIterations, int iterations, int benchworkLoad) {
		this.gson = new Gson();
		setupBenchmark(benchworkLoad);
		this.warmUpIterations = warmUpIterations;
		this.iterations = iterations;
	}

	@Override
	public void warmup() throws IOException, InterruptedException {
		String res = null;
		GsonClassOne converted = null;
		for(int i = 0; i < this.warmUpIterations; i++){
            res = gson.toJson(classOne);
            converted = gson.fromJson(classOneJson,GsonClassOne.class);
        }
	}

	@Override
	public void run() throws IOException, InterruptedException {
		String res = null;
		GsonClassOne converted = null;
		for(int i = 0; i < this.iterations; i++){
            res = gson.toJson(classOne);
            converted = gson.fromJson(classOneJson,GsonClassOne.class);
        }
	}
	
	

    private void setupBenchmark(int benchworkLoad){
        //setting up class for benchmark
        classOne = new GsonClassOne();
        classOne.setV1(1);
        classOne.setV2(2L);
        classOne.setV3("Benchmarked");
        classOne.setV4(3.5f);
        classOne.setV5(3.6);

        List<Integer> v6 = new ArrayList<Integer>();
        for(int i = 0; i < benchworkLoad;i++){
            v6.add(i);
        }
        classOne.setV6(v6);

        List<String> v7 = new ArrayList<String>();
        for(int i = 0; i < benchworkLoad;i++){
            v7.add(String.valueOf(i));
        }
        classOne.setV7(v7);

        Gson gson = new Gson();
        classOneJson = gson.toJson(classOne);
    }

}

final class GsonClassOne {
    private int v1;
    private long v2;
    private String v3;
    private float v4;
    private double v5;
    private List<Integer> v6;
    private List<String> v7;

    public long getV2() {
        return v2;
    }

    public void setV2(long v2) {
        this.v2 = v2;
    }

    public String getV3() {
        return v3;
    }

    public void setV3(String v3) {
        this.v3 = v3;
    }

    public float getV4() {
        return v4;
    }

    public void setV4(float v4) {
        this.v4 = v4;
    }

    public double getV5() {
        return v5;
    }

    public void setV5(double v5) {
        this.v5 = v5;
    }

    public List<Integer> getV6() {
        return v6;
    }

    public void setV6(List<Integer> v6) {
        this.v6 = v6;
    }

    public List<String> getV7() {
        return v7;
    }

    public void setV7(List<String> v7) {
        this.v7 = v7;
    }

    public int getV1() {

        return v1;
    }

    public void setV1(int v1) {
        this.v1 = v1;
    }
}
