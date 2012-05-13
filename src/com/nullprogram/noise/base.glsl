#version 110

varying float magnitude;

void main()
{
    gl_FragColor = vec4(magnitude, 0, 0, 0);
}
