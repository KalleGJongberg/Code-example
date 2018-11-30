#include <omp.h>
/* Author Kalle Jongberg
made 8/11 2018
This is a program there calculate matrix array produkt row wise, and this is done i parrel.
*/
void omp_dgemv_v1(
    int m,         /* number of rows                   */
    int n,         /* number of columns                */
    double alpha,  /* scalar                           */
    double ** A,   /* two-dim. array A of size m-by-n  */
    double * x,    /* one-dim. array x of length n     */
    double beta,   /* scalar                           */
    double * y     /* one-dim. array x of length m     */
) {
  // beginging parrel
  #pragma omp parallel for
  // calcultating routine
    for (int i = 0; i < m; i++) {
      double sum = 0;
      for (int j = 0; j < n; j++) {
        sum += A[i][j]*x[j];
      }
      y[i] = alpha*sum+beta*y[i];
    }
    return;
}
