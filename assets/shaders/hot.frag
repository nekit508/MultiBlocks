#define HIGHP
varying vec2 v_texCoords;
uniform vec2 rand;
uniform sampler2D r_texture;

void main(){
    float x = v_texCoords.x + rand.x;
    float y = v_texCoords.y + rand.y;
    vec4 color = texture2D(r_texture, vec2(x, y));
    gl_FragColor = color;
}