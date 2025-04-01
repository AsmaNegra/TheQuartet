<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class AppController extends AbstractController
{
    #[Route('/todo', name: 'todo')]
    public function todo(): Response
    {
        return $this->render('app/todo.html.twig');
    }

    #[Route('/chat', name: 'chat')]
    public function chat(): Response
    {
        return $this->render('app/chat.html.twig');
    }

    #[Route('/calendar', name: 'calendar')]
    public function calendar(): Response
    {
        return $this->render('app/calendar.html.twig');
    }   
    
}
