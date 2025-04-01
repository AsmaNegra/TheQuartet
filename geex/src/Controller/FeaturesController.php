<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class FeaturesController extends AbstractController
{
    #[Route('/chart', name: 'chart')]
    public function chart(): Response
    {
        return $this->render('features/chart.html.twig');
    }

 #[Route('/badge', name: 'badge')]
    public function badge(): Response
    {
        return $this->render('features/badge.html.twig');
    }

 #[Route('/button', name: 'button')]
    public function button(): Response
    {
        return $this->render('features/button.html.twig');
    }

 #[Route('/color', name: 'color')]
    public function color(): Response
    {
        return $this->render('features/color.html.twig');
    }

 #[Route('/form', name: 'form')]
    public function form(): Response
    {
        return $this->render('features/form.html.twig');
    }

 #[Route('/icon', name: 'icon')]
    public function icon(): Response
    {
        return $this->render('features/icon.html.twig');
    }

 #[Route('/navigation', name: 'navigation')]
    public function navigation(): Response
    {
        return $this->render('features/navigation.html.twig');
    }

 #[Route('/typography', name: 'typography')]
    public function typography(): Response
    {
        return $this->render('features/typography.html.twig');
    }


}
