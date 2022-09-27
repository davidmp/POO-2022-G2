package pe.edu.upeu.gui.planoc;
import java.awt.*;

/**
 *  A basic function class, more in the graphic sense than 
 *  in the mathematical sense.
 */
public class Function {
  private String name;
  private String variable;
  private String definition;
  private int degree;
  private boolean active;
  private Parser parser;
  private Color color;


  public Function()
  {
    parser = new Parser();
    setActive(true);
  }

  public Function(String definition, String name)
  {
    parser = new Parser(definition);
    setDefinition(definition);
    setActive(true);
    setName(name);
  }

  public Color getColor()
  {
    return color;
  }

  public void setColor(Color color)
  {
    this.color = color;
  }

  public boolean isActive()
  {
    return active;
  }

  public void setActive(boolean active)
  {
    this.active = active;
  }


  public String getVariable()
  {
    return variable;
  }

  public void setVariable(String variable)
  {
    this.variable = variable;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getDefinition() {
    return definition;
  }

  public void setDefinition(String definition) {
    this.definition = definition;
  }

  public int getDegree() {
    return degree;
  }

  public void setDegree(int degree) {
    this.degree = degree;
  }

  public double evaluate(double x)
  {
    parser.setVariable("x", x);
    double fx = parser.evaluate();
    if (parser.getErrorCode() != Parser.SUCCESS)
      return Double.NaN;
    return fx;
  }

  @Override
  public String toString()
  {
    return name + " = " + getDefinition();
  }
}

