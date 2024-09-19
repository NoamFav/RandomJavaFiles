

public class ODEsolverComplexAna {
    public static void main(String[] args) {

        float[] x0 = {0, 1};
        float[] y0 = {1, 2};
        float h = 0.025f;
        float[] targetX = {0.1f};

        System.out.println("Euler approximation: " + calculateApproximationEuler(x0, y0, h, targetX)[0]);
        System.out.println("Euler approximation: " + calculateApproximationEuler(x0, y0, h, targetX)[1]);

        System.out.println("Improved euler approximation: " + calculateApproximationImprovedEuler(x0, y0, h, targetX)[0]);
        System.out.println("Improved euler approximation: " + calculateApproximationImprovedEuler(x0, y0, h, targetX)[1]);

        System.out.println("RK4 approximation: " + calculateApproximationRK4(x0, y0, h, targetX)[0]);
        System.out.println("RK4 approximation: " + calculateApproximationRK4(x0, y0, h, targetX)[1]);

    }

    public static float[] calculateApproximationEuler(float[] x0, float[] y0, float h, float[] targetX) {

        float[] x = x0.clone();
    
        while (x[0] < targetX[0]) {
            float[] k1 = calculateROC(x, y0);
            for (int i = 0; i < x.length; i++) {
                x[i] = x[i] + h * k1[i];
            }
            x[0] = x[0] + h;
        }
    
        return x;
    }
    
    public static float[] calculateApproximationImprovedEuler(float[] x0, float[] y0, float h, float[] targetX) {
        
        float[] x = x0.clone();
    
        while (x[0] < targetX[0]) {
            float[] k1 = calculateROC(x, y0);
            float[] k2 = calculateROC(sumArray(x, multiplyArrByScalar(k1, h)), y0);
            for (int i = 0; i < x.length; i++) {
                x[i] = x[i] + (k1[i] + k2[i]) / 2;
            }
            x[0] = x[0] + h;
        }
    
        return x;
    }
    
    public static float[] calculateApproximationRK4(float[] x0, float[] y0, float h, float[] targetX) {

        float[] x = x0.clone();
    
        while (x[0] < targetX[0]) {
            float[] k1 = calculateROC(x, y0);
            float[] k2 = calculateROC(sumArray(x, multiplyArrByScalar(k1, h / 2)), y0);
            float[] k3 = calculateROC(sumArray(x, multiplyArrByScalar(k2, h / 2)), y0);
            float[] k4 = calculateROC(sumArray(x, multiplyArrByScalar(k3, h)), y0);

            for (int i = 0; i < x.length; i++) {
                x[i] = x[i] + (k1[i] + 2 * k2[i] + 2 * k3[i] + k4[i]) / 6;
            }

            x[0] = x[0] + h;
        }
    
        return x;
    }
    
    private static float[] calculateROC(float[] x, float[] y0) {

        float[] result = new float[x.length];

        for (int i = 0; i < x.length; i++) {
            result[i] = x[i] * y0[i];
        }

        return result;
    }

    private static float[] sumArray(float[] arr1, float[] arr2) {

        float[] sumsArray = new float[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            sumsArray[i] = arr1[i] + arr2[i];
        }

        return sumsArray;
    }

    private static float[] multiplyArrByScalar(float[] inputArray, float scalar) {

        float[] multipliedArray = new float[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            multipliedArray[i] = inputArray[i] * scalar;
        }

        return multipliedArray;
    }
}
