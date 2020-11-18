This is the configuration project for yocto targeting console-image for Beaglebone-Black boards

To build yocto please clone the following yocto git repositories:

- git clone -b dunfell git://git.yoctoproject.org/poky.git poky-dunfell
- git clone -b dunfell git://git.openembedded.org/meta-openembedded poky-dunfell/meta-openembedded

To use the bbb meta layer perform the following commands:

- mkdir bbb
- cd bbb
- git clone https://github.com/mkauli/meta-bbb.git
- git clone https://github.com/mkauli/yocto_bbb.git .
- edit file: build/conf/bblayers.conf  - adjust the HOME path
- source poky-dunfell/oe-init-build-env ./bbb/build
- bitbake console-image


