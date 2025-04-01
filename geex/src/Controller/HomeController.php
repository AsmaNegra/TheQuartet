<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class HomeController extends AbstractController
{
    #[Route('/', name: 'root')]
    #[Route('/index', name: 'index')]
    public function index(): Response
    {
        return $this->render('home/index.html.twig');
    }

    #[Route('/index2', name: 'index2')]
    public function index2(): Response
    {
        return $this->render('home/index2.html.twig');
    }

    #[Route('/index3', name: 'index3')]
    public function index3(): Response
    {
        return $this->render('home/index3.html.twig');
    }

    #[Route('/index4', name: 'index4')]
    public function index4(): Response
    {
        return $this->render('home/index4.html.twig');
    }
}
