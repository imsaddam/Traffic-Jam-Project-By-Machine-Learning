
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import weka.classifiers.Classifier;
import java.io.Serializable;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.FastVector;
import weka.core.Instances;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cse
 */
public class weka {
    
    public String ClassifyInstance( String[] features) throws IOException, ClassNotFoundException, Exception
    {
        //String cl="";
        ObjectInputStream ois = new ObjectInputStream(
                           new FileInputStream("Lab project model.model"));// load model
        Classifier classifier = (Classifier) ois.readObject();
        ois.close();
        Instance newIns = createInstance(features);// create new Instance
        double cls = classifier.classifyInstance(newIns);// classify the new instance
        System.out.print(classifier.classifyInstance(newIns));
        return Double.toString(cls);// return class
                
        
    }
    public Instance createInstance(String[] features)
    {
        System.out.println(features);
        //declaring attributes
        // deeclare numeric attribute
        FastVector myNomVals = new FastVector();
        
        
        FastVector fvNominalVal13 = new FastVector(5);
        fvNominalVal13.addElement("saturday");
        fvNominalVal13.addElement("sunday");
        fvNominalVal13.addElement("monday");
        fvNominalVal13.addElement("tuesday");
        fvNominalVal13.addElement("wednesday");   
        fvNominalVal13.addElement("thursday");
        fvNominalVal13.addElement("friday");
        Attribute Attribute1 = new Attribute("Day",fvNominalVal13);

        Attribute Attribute2 = new Attribute("Time");
        // declare nominal attribute
        
        
        FastVector fvNominalVal1 = new FastVector(2);
        fvNominalVal1.addElement("yes");
        fvNominalVal1.addElement("no");            
        Attribute Attribute3 = new Attribute("Holiday/Hartal",fvNominalVal1);
        
        FastVector fvNominalVal2 = new FastVector(2);
        fvNominalVal2.addElement("yes");
        fvNominalVal2.addElement("no"); 
        Attribute Attribute4 = new Attribute("Educational/Institute",fvNominalVal2);
        
        FastVector fvNominalVal3 = new FastVector(2);
        fvNominalVal3.addElement("yes");
        fvNominalVal3.addElement("no"); 
        Attribute Attribute5 = new Attribute("Commercial_Area",fvNominalVal3);
        
        FastVector fvNominalVal4 = new FastVector(2);
        fvNominalVal4.addElement("yes");
        fvNominalVal4.addElement("no"); 
        Attribute Attribute6 = new Attribute("Public_Gathering",fvNominalVal4);
        
        FastVector fvNominalVal5 = new FastVector(2);
        fvNominalVal5.addElement("yes");
        fvNominalVal5.addElement("no"); 
        Attribute Attribute7 = new Attribute("Signal",fvNominalVal5);
        
        FastVector fvNominalVal6 = new FastVector(2);
        fvNominalVal6.addElement("yes");
        fvNominalVal6.addElement("no"); 
        Attribute Attribute8 = new Attribute("VIP_Passing",fvNominalVal6);
        
        
        FastVector fvNominalVal = new FastVector(5);
        fvNominalVal.addElement("0");
        fvNominalVal.addElement("1");
        fvNominalVal.addElement("2");
        fvNominalVal.addElement("3");
        fvNominalVal.addElement("4");   
        fvNominalVal.addElement("5");   
        Attribute Attribute9 = new Attribute("Road_Condition",fvNominalVal);
        
        Attribute Attribute10 = new Attribute("Road/Place_Name", (FastVector) null);
        
         //attributes.addElement(new Attribute("Road/Place_Name", (FastVector) null));

        
        FastVector fvClassVal = new FastVector(2);
        fvClassVal.addElement("yes");
        fvClassVal.addElement("no");
        Attribute Class = new Attribute("class", fvClassVal);
        // add all the attribute in the weka attributes list
        FastVector fvWekaAttributes = new FastVector(14);
        fvWekaAttributes.addElement(Attribute1);
        fvWekaAttributes.addElement(Attribute2);
        fvWekaAttributes.addElement(Attribute3);
        fvWekaAttributes.addElement(Attribute4);
        fvWekaAttributes.addElement(Attribute5);
        fvWekaAttributes.addElement(Attribute6);
        fvWekaAttributes.addElement(Attribute7);
        fvWekaAttributes.addElement(Attribute8);
        fvWekaAttributes.addElement(Attribute9);
        fvWekaAttributes.addElement(Attribute10);
        fvWekaAttributes.addElement(Class);
        
        Instances dataset = new Instances("whatever", fvWekaAttributes, 0);
        dataset.setClassIndex(dataset.numAttributes()-1);
        Instance iExample = new DenseInstance(features.length);
        
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(0), features[0]);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), Double.parseDouble(features[1]));
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), features[2]);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), features[3]);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(4), features[4]);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(5), features[5]);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(6), features[6]);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(7), features[7]);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(8), features[8]);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(9), features[9]);
   //     iExample.setValue((Attribute)fvWekaAttributes.elementAt(10), features[10]);
   //     iExample.setValue((Attribute)fvWekaAttributes.elementAt(11), features[11]);
   //     iExample.setValue((Attribute)fvWekaAttributes.elementAt(12), features[12]);
         
        dataset.add(iExample);
        
        return dataset.instance(0);
       
        
    }
    
}
