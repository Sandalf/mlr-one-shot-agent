package examples.behaviours;

public class MatrixOperations {

    public MatrixOperations() {}

    public static double[] cramer(double[][] m) {
      double[] result;
      result = new double[3];

      double Ds = (
        (
          (m[0][0] * m[1][1] * m[2][2])
        + (m[0][1] * m[1][2] * m[0][2])
        + (m[0][2] * m[1][0] * m[2][1]))
        - (
          (m[2][0] * m[1][1] * m[0][2])
        + (m[2][1] * m[1][2] * m[0][0])
        + (m[2][2] * m[1][0] * m[0][1])
        ));        
  
      double B0 = (
        (
          (m[0][3] * m[1][1] * m[2][2])
        + (m[0][1] * m[1][2] * m[2][3])
        + (m[0][2] * m[1][3] * m[2][1])
        - (
          (m[2][3] * m[1][1] * m[0][2])
        + (m[2][1] * m[1][2] * m[0][3])
        + (m[2][2] * m[1][3] * m[0][1]))
        ));

      double B1 = (
        (
          (m[0][0] * m[1][3] * m[2][2])
        + (m[0][3] * m[1][2] * m[2][0])
        + (m[0][2] * m[1][0] * m[2][3]))
        - (
          (m[0][2] * m[1][3] * m[0][2])
        + (m[2][3] * m[1][2] * m[0][0])
        + (m[2][2] * m[1][0] * m[0][3])
        ));

      double B2 = (
        (
          (m[0][0] * m[1][1] * m[2][3])
        + (m[0][1] * m[1][3] * m[2][0])
        + (m[0][3] * m[1][0] * m[2][1]))
        - (
          (m[2][0] * m[1][1] * m[0][3])
        + (m[2][1] * m[1][3] * m[0][0])
        + (m[2][3] * m[1][0] * m[0][1])
        ));

      result[0] = B0 / Ds;
      result[1] = B1 / Ds;
      result[2] = B2 / Ds;
      return result;
    }
}