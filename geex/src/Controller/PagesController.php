<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class PagesController extends AbstractController
{
    #[Route('/blog', name: 'blog')]
    public function blog(): Response
    {
        return $this->render('pages/blog.html.twig');
    }

    #[Route('/blog-details', name: 'blogDetails')]
    public function blblogDetailsog(): Response
    {
        return $this->render('pages/blogDetails.html.twig');
    }

  #[Route('/faq', name: 'faq')]
    public function faq(): Response
    {
        return $this->render('pages/faq.html.twig');
    }

  #[Route('/pricing', name: 'pricing')]
    public function pricing(): Response
    {
        return $this->render('pages/pricing.html.twig');
    }

  #[Route('/testimonial', name: 'testimonial')]
    public function testimonial(): Response
    {
        return $this->render('pages/testimonial.html.twig');
    }

  #[Route('/terms', name: 'terms')]
    public function terms(): Response
    {
        return $this->render('pages/terms.html.twig');
    }

  #[Route('/signin', name: 'signin')]
    public function signin(): Response
    {
        return $this->render('pages/signin.html.twig');
    }

  #[Route('/signup', name: 'signup')]
    public function signup(): Response
    {
        return $this->render('pages/signup.html.twig');
    }

  #[Route('/forgot-password', name: 'forgot-password')]
    public function forgetPassword(): Response
    {
        return $this->render('pages/forgot-password.html.twig');
    }

  #[Route('/verification', name: 'verification')]
    public function verification(): Response
    {
        return $this->render('pages/verification.html.twig');
    }

  #[Route('/error', name: 'error')]
    public function error(): Response
    {
        return $this->render('pages/error.html.twig');
    }

  #[Route('/coming-soon', name: 'comingSoon')]
    public function commingSoon(): Response
    {
        return $this->render('pages/comingSoon.html.twig');
    }

  #[Route('/maintenance', name: 'maintenance')]
    public function maintenance(): Response
    {
        return $this->render('pages/maintenance.html.twig');
    }

  #[Route('/blank-page', name: 'blankPage')]
    public function blankPage(): Response
    {
        return $this->render('pages/blankPage.html.twig');
    }
    #[Route('/landing', name: 'landing')]
    public function landing(): Response
    {
        return $this->render('pages/landingPage.html.twig');
    }
}
