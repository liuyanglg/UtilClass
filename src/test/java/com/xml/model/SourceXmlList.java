package com.xml.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "list")
public class SourceXmlList {
    List<SourceXml> sourceXmlList;

    @XmlElement(name="source")
    public List<SourceXml> getSourceXmlList() {
        return sourceXmlList;
    }

    public void setSourceXmlList(List<SourceXml> sourceXmlList) {
        this.sourceXmlList = sourceXmlList;
    }
}
