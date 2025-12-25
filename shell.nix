{pkgs ? import <nixpkgs> {}}: let
  packages = with pkgs; [
    zulu8
  ];

  libraries = with pkgs; [
    libxkbcommon
    libiconv
    libGL

    stdenv.cc.cc.lib

    # WINIT_UNIX_BACKEND=wayland
    wayland

    # WINIT_UNIX_BACKEND=x11
    xorg.libXcursor
    xorg.libXrandr
    xorg.libXi
    xorg.libX11
  ];
in
  with pkgs;
    mkShell {
      name = "vanilla-rpc";
      buildInputs = packages ++ libraries;

      DIRENV_LOG_FORMAT = "";
      LD_LIBRARY_PATH = "${lib.makeLibraryPath libraries}:$LD_LIBRARY_PATH";
    }
