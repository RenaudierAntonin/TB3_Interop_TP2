import java.io.File;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.transform.OutputKeys;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerException;

import javax.xml.transform.TransformerFactory;

import javax.xml.transform.dom.DOMSource;

import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

public class main {
    private static final String xmlFilePath = "C:\\Users\\anton\\Desktop\\Cours\\2A\\TB3\\Interop\\xmlfile.xml";
    public static void main(String argv[]) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("Entreprise");
            document.appendChild(root);
            Element employee = document.createElement("employé");
            root.appendChild(employee);
            Attr attr = document.createAttribute("id");
            attr.setValue("15");
            employee.setAttributeNode(attr);
            Element firstName = document.createElement("Prenom");
            firstName.appendChild(document.createTextNode("Antonin"));
            employee.appendChild(firstName);
            Element lastname = document.createElement("Nom");
            lastname.appendChild(document.createTextNode("Renaudier"));
            employee.appendChild(lastname);
            Element email = document.createElement("email");
            email.appendChild(document.createTextNode("antonin.renaudier@etu.emse.fr"));
            employee.appendChild(email);
            Element department = document.createElement("Secteur");
            department.appendChild(document.createTextNode("Informatique"));
            employee.appendChild(department);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
            transformer.transform(domSource, streamResult);
            System.out.println("Done creating XML File");
        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }
}
