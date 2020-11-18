This is the configuration project for yocto targeting console-image for Beaglebone-Black boards

To build yocto please clone the following yocto git repositories into an empty directory (i.e. your yocto source directory):

- git clone -b dunfell https://git.yoctoproject.org/poky.git poky-dunfell
- git clone -b dunfell https://git.openembedded.org/meta-openembedded poky-dunfell/meta-openembedded
- git clone -b dunfell https://git.yoctoproject.org/git/meta-security poky-dunfell/meta-security
- git clone -b dunfell https://github.com/jumpnow/meta-jumpnow.git poky-dunfell/meta-jumpnow


To use the bbb meta layer perform the following commands inside your yocto source directory:

- git clone --recurse-submodules https://github.com/mkauli/yocto_bbb.git bbb
- edit file: bbb/build/conf/bblayers.conf  - adjust the HOME path
- source poky-dunfell/oe-init-build-env ./bbb/build
- bitbake console-image


