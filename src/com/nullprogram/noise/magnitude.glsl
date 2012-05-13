#version 110

attribute vec2 position;

varying float magnitude;

void main()
{
    gl_Position = vec4(position, 0, 0);
    magnitude = sqrt(position.x * position.x + position.y * position.y);
}
