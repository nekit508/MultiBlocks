#define HIGHP
uniform float u_time;

void main(){
    float x = gl_FragCoord.x;
    float y = gl_FragCoord.y;
    float b = sin(x*u_time)*sin(y*u_time);
    float g = cos(x*u_time)*cos(y*u_time);
    float r = tan(x*u_time)*tan(y*u_time);;

    float a = 1.0;
    gl_FragColor = vec4(r,g,b,a);
}