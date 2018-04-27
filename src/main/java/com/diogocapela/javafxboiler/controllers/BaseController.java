package com.diogocapela.javafxboiler.controllers;

import com.diogocapela.javafxboiler.models.Empresa;

abstract class BaseController {

    Empresa empresa;

    public BaseController() {
        System.out.println("BaseController: BaseController()");
        empresa = Empresa.getInstance();
    }

}
