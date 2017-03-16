# Adaptive Brightness

This is a simple Java program that runs on **Linux Systems**. It helps in
identifying when your laptop is not charging by adapting the brighness based on
the charging status.

For this program to work you need to install:
* acpi
* xbacklight

### To install __acpi__
Run this on command line

```
apt-get update
```

```
apt-get install acpi
```

### To install __xbacklight__
Run this on command line

```
apt-get update
```

```
apt-get install xbacklight
```
# Basic Installation

1. Move the `dist/AdaptiveBrightness.jar` file to `/usr/bin/`
2. Move the `dist/a_bright` to `/usr/bin`
3. Enable execution permissions

```
chmod +x /usr/bin/a_bright
```

4. Now run this on terminal
```
a_bright
```
