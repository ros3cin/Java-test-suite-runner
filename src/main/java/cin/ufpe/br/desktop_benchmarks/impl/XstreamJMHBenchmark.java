package cin.ufpe.br.desktop_benchmarks.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import cin.ufpe.br.desktop_benchmarks.api.IBenchmark;

public class XstreamJMHBenchmark implements IBenchmark {
	private XstreamClassOne classOne;
	private String classOneXmlString;
    private XStream xstream;
	
	public XstreamJMHBenchmark() {
		setupBenchmark();
	}
	
	@Override
	public void warmup() throws IOException, InterruptedException {
		for(int i = 0; i < 1; i++){
            xstream.toXML(classOne);
            xstream.fromXML(classOneXmlString);
        }
	}

	@Override
	public void run() throws IOException, InterruptedException {
		for(int i = 0; i < 10; i++){
            xstream.toXML(classOne);
            xstream.fromXML(classOneXmlString);
        }
	}
	
	private void setupBenchmark() {
        classOne = new XstreamClassOne();
        classOne.setField1("Field 1");
        classOne.setField2(2);
        classOne.setField3(3.1f);
        classOne.setField4(4.1);
        classOne.setField5(5L);

        List<String> field6 = new ArrayList<String>();
        for(int i = 0; i < 2500; i++) {
            field6.add(String.valueOf(i));
        }
        classOne.setField6(field6);

        List<Integer> field7 = new ArrayList<Integer>();
        for(int i = 0; i < 2500; i++) {
            field7.add(i);
        }
        classOne.setField7(field7);

        xstream = new XStream(new DomDriver());
        xstream.allowTypes(XstreamClassOne.class);
        classOneXmlString = xstream.toXML(classOne);
    }

}

final class XstreamClassOne {
    private String field1;
    private int field2;
    private float field3;
    private double field4;
    private long field5;
    private List<String> field6;
    private List<Integer> field7;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public int getField2() {
        return field2;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    public float getField3() {
        return field3;
    }

    public void setField3(float field3) {
        this.field3 = field3;
    }

    public double getField4() {
        return field4;
    }

    public void setField4(double field4) {
        this.field4 = field4;
    }

    public long getField5() {
        return field5;
    }

    public void setField5(long field5) {
        this.field5 = field5;
    }

    public List<String> getField6() {
        return field6;
    }

    public void setField6(List<String> field6) {
        this.field6 = field6;
    }

    public List<Integer> getField7() {
        return field7;
    }

    public void setField7(List<Integer> field7) {
        this.field7 = field7;
    }
}
