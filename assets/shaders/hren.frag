#define HIGHP
uniform float u_time;
varying vec2 v_texCoords;
uniform sampler2D r_texture;

void main(){
    float x = v_texCoords.x;
    float y = v_texCoords.y;
    vec2 coords = v_texCoords;
    vec4 color = texture2D(r_texture, coords);
    color[2] = sin(x+u_time*2.0);
    gl_FragColor = color;
}